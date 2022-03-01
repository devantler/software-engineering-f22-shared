using DSLCompiler.Generators.Base;
using DSLCompiler.Metamodel.Base;

namespace DSLCompiler.Generators.LogicGenerator;

public class LogicGenerator : IGenerator
{
    public string Name { get; set; } = null!;

    public Dictionary<string, string> Generate(IModel model)
    {
        throw new NotImplementedException();
    }
}
