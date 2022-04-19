using DSLParser.Tokens;

namespace DSLParser.Parsers.ConfigurationParser;

public class ConfigurationTokenType : TokenType
{
    public static ConfigurationTokenType Create { get; set; } = new(1, nameof(Create));
    public static ConfigurationTokenType With { get; set; } = new(2, nameof(With));
    public static ConfigurationTokenType None { get; set; } = new(3, nameof(None));

    public ConfigurationTokenType(int id, string name) : base(id, name)
    {
    }
}
