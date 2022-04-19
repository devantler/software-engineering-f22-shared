FROM ghcr.io/hounsvad/dotnet-runtime-fswebcam:6.0 AS final
WORKDIR /app
ARG TARGETARCH
ADD ./${TARGETARCH}.tar /app
ENTRYPOINT ["dotnet", "CameraColorScanner.dll"]
