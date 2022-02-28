using DSLCompiler.IO;
using DSLCompiler.Metamodel.Base;
using DSLCompiler.Parsers.Base;

namespace DSLCompiler.Parsers.LogicParser;

public class LogicParser : Parser
{
    protected override Dictionary<Guid, Token> Tokenize(FileCollection files)
    {
        throw new NotImplementedException();
    }
    protected override IModel Parse(Dictionary<Guid, Token> tokens)
    {
        throw new NotImplementedException();
    }
    protected override IModel Finalize(IModel model)
    {
        throw new NotImplementedException();
    }
}
