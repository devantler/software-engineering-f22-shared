FROM mcr.microsoft.com/dotnet/runtime:6.0 AS final
WORKDIR /app
ARG TARGETARCH
ADD ./${TARGETARCH}.tar /app/publish
ENTRYPOINT ["dotnet", "CameraColorScanner.dll"]
