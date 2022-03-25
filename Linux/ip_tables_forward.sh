#!/bin/bash

print_usage(){
    echo
    echo "Usage: $0 <output interface>"
    echo "The script needs root access to run."
    echo "Available interfaces:"
    for i in $interfaces; do
        echo $i
    done
    exit 1
}

interfaces=$(ip a | grep -oE '[1-9]: [0-9a-z]{0,7}:'\
                  | grep -oE '[0-9a-z]{1,7}:$' \
                  | grep -oE '^[0-9a-z]{1,7}')

# Print usage if user is not root
if [[ $EUID -ne 0 ]]; then
    echo "This script must be run as root" 1>&2
    exit 1
fi

echo "There are $# arguments"
# Print usage if no arguments are given
if [[ $# -lt 1 ]]; then
    print_usage
fi

# Use grep to see if one of the interfaces matches using regex
selected_output_interface=$(grep -oE "^$1$" <<< $interfaces)

# 
if [[ $selected_output_interface == $1 ]]; then
    echo "Interface $1 is available"
else
    echo "Interface $1 is not available" 1>&2
    print_usage
fi

sysctl -w net.ipv4.ip_forward=1
iptables -t nat -A POSTROUTING -o $selected_output_interface -j MASQUERADE