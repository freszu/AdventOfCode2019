import java.io.File

fun loadFileByLine(filename: String): List<String> {
    val file = ClassLoader.getSystemResource(filename).file
    return File(file).readLines()
}
