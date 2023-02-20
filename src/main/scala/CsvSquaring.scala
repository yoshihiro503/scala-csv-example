import java.io._
import scala.io.Source

object CsvSquaring {
  def main(args: Array[String]): Unit = {
    val inputFileName = "./data/input.csv"
    val outputFileName = "./data/output.csv"

    val outputFile = new BufferedWriter(new FileWriter(outputFileName))
    val inputSource = Source.fromFile(inputFileName)
    var i = 0
    for (line <- inputSource.getLines()) {
      if (i == 0) {
        outputFile.write(line + "\n")
      } else {
        val cols = line.split(",").map(_.trim)
        val squaredCol2 = cols(1).toInt * cols(1).toInt
        val newLine = s"${cols(0)},$squaredCol2,${cols(2)}"
        outputFile.write(newLine + "\n")
      }
      i += 1
    }
    inputSource.close()
    outputFile.close()
  }
}

