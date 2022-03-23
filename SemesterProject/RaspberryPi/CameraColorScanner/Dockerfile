FROM mcr.microsoft.com/dotnet/runtime:6.0 AS base
WORKDIR /app

FROM mcr.microsoft.com/dotnet/sdk:6.0 AS build
WORKDIR /src
COPY ["CameraColorScanner.csproj", "./"]
RUN dotnet restore "CameraColorScanner.csproj"
COPY . .
WORKDIR "/src/"
RUN dotnet build "CameraColorScanner.csproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "CameraColorScanner.csproj" -c Release -o /app/publish

FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "CameraColorScanner.dll"]
