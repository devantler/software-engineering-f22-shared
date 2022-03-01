using DSLCompiler.Metamodel.Base;

namespace DSLCompiler.Generators.Base;
public interface IGenerator
{
    public string Name { get; set; }
    Dictionary<string, string> Generate(IModel model);
}
