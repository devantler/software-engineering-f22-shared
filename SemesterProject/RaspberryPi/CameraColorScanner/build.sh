
folder=./SemesterProject/RaspberryPi/CameraColorScanner
tag=ghcr.io/devantler/software-engineering-f22/camera-color-scanner
csplit --digits=2 --suppress-matched --quiet --prefix=$folder/Dockerfile $folder/Dockerfile "/#buildxprebuildabove/1" "{*}"
mv $folder/Dockerfile01 $folder/Dockerfile
docker buildx build --cache-to=type=local,dest=/tmp/cache --build-arg TARGETPLATFORM=linux/amd64 -f $folder/Dockerfile00 -t app:amd64 $folder
docker buildx build --cache-to=type=local,dest=/tmp/cache --build-arg TARGETPLATFORM=linux/arm64 -f $folder/Dockerfile00 -t app:arm64 $folder
docker buildx build --cache-to=type=local,dest=/tmp/cache --build-arg TARGETPLATFORM=linux/arm/v7 -f $folder/Dockerfile00 -t app:arm $folder
echo -e "FROM app:\${TARGETARCH} as copy-state\nARG TARGETARCH\n$(cat $folder/Dockerfile)" > $folder/Dockerfile
docker buildx build --cache-from=type=local,dest=/tmp/cache --push -t $tag:latest --platform linux/arm/v7,linux/arm64,linux/amd64 $folder