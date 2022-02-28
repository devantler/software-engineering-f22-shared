namespace DSLCompiler.Metamodel.Base;

public abstract class Model : IModel
{
    public string Name { get; set; } = null!;
    public string Description { get; set; } = null!;
}
