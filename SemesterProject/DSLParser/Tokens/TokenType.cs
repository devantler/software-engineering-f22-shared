using DSLParser.Helpers;

namespace DSLParser.Tokens;

public abstract class TokenType : Enumeration
{
    protected TokenType(int id, string name) : base(id, name)
    {
    }
}
