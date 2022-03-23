FROM mcr.microsoft.com/dotnet/runtime:6.0 AS base
WORKDIR /app

FROM mcr.microsoft.com/dotnet/sdk:6.0 AS build

WORKDIR /src
COPY ["CameraColorScanner.csproj", "./"]
ARG TARGETARCH
RUN if [ "$TARGETARCH" = "amd64" ]; then \
        RID=linux-x64 ; \
    elif [ "$TARGETARCH" = "arm64" ]; then \
        RID=linux-arm64 ; \
    elif [ "$TARGETARCH" = "arm" ]; then \
        RID=linux-arm ; \
    else\
        RID=linux-x64 ; \
    fi \
    && dotnet restore -r $RID "CameraColorScanner.csproj"
COPY . .
WORKDIR "/src/"
RUN dotnet build "CameraColorScanner.csproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "CameraColorScanner.csproj" -c Release -o /app/publish

FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "CameraColorScanner.dll"]
