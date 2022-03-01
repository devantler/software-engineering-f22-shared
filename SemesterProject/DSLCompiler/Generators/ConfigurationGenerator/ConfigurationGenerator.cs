using DSLCompiler.Generators.Base;
using DSLCompiler.Metamodel.Base;

namespace DSLCompiler.Generators.ConfigurationGenerator;

public class ConfigurationGenerator : IGenerator
{
    public string Name { get; set; } = null!;

    public Dictionary<string, string> Generate(IModel model)
    {
        throw new NotImplementedException();
    }
}
