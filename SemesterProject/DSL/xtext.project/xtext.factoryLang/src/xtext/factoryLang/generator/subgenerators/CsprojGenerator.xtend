package xtext.factoryLang.generator.subgenerators

import org.eclipse.xtext.generator.IFileSystemAccess2

class CsprojGenerator {
	
	def static generate(IFileSystemAccess2 fsa) {
			fsa.generateFile('OrchestratorService/OrchestratorService.csproj', 
			'''
			<Project Sdk="Microsoft.NET.Sdk">
			
			    <PropertyGroup>
			        <OutputType>Exe</OutputType>
			        <TargetFramework>net6.0</TargetFramework>
			        <ImplicitUsings>enable</ImplicitUsings>
			        <Nullable>enable</Nullable>
			    </PropertyGroup>
				
				<ItemGroup>
					<PackageReference Include="MQTTnet" Version="3.1.2"/>
					<PackageReference Include="MQTTnet.Extensions.ManagedClient" Version="3.1.2"/>
				</ItemGroup>
			</Project>
			'''
		)
	}

}