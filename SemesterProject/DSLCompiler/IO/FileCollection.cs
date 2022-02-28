using System.Collections;

namespace DSLCompiler.IO;

public class FileCollection : IEnumerable<FileInfo>
{
    public List<FileInfo> Files { get; set; } = new();

    public IEnumerator<FileInfo> GetEnumerator()
    {
        return ((IEnumerable<FileInfo>)Files).GetEnumerator();
    }

    IEnumerator IEnumerable.GetEnumerator()
    {
        return GetEnumerator();
    }
}
