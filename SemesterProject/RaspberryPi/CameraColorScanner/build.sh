
folder=./SemesterProject/RaspberryPi/CameraColorScanner
tag=ghcr.io/devantler/software-engineering-f22/camera-color-scanner
docker buildx build -o type=tar,dest=- --build-arg TARGETPLATFORM=linux/amd64 -f $folder/DockerfileBuild -t app:amd64 $folder > $folder/amd64.tar
docker buildx build -o type=tar,dest=- --build-arg TARGETPLATFORM=linux/arm64 -f $folder/DockerfileBuild -t app:arm64 $folder > $folder/arm64.tar
docker buildx build -o type=tar,dest=- --build-arg TARGETPLATFORM=linux/arm/v7 -f $folder/DockerfileBuild -t app:arm $folder > $folder/arm.tar
docker buildx build --push -t $tag:latest --platform linux/arm/v7,linux/arm64,linux/amd64 $folder