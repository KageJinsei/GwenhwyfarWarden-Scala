package com.KageJinsei.GwenhwyfarWarden

import scala.io.StdIn.readLine
import scala.util.Random

object RandomGenerate {

  def randomUpLetters(): Array[Char] = {
    ('A' to 'Z').toArray
  }
  
  def randomLcLetters(): Array[Char] = {
    ('a' to 'z').toArray
  }
  
  def randomNumbers(): Array[Char] = {
    ('0' to '9').toArray
  }

  def genCharacters(addUp: Boolean, addLc: Boolean, addNum: Boolean): Array[Char] = {
    val chars = scala.collection.mutable.ArrayBuffer[Char]()
    if (addUp) chars ++= randomUpLetters()
    if (addLc) chars ++= randomLcLetters()
    if (addNum) chars ++= randomNumbers()
    chars.toArray
  }

  def randomCharacters(count: Int, characters: Array[Char]): Unit = {
    val random = new Random()
    if (count > 0 && characters.nonEmpty) {
      val generatedChars = (1 to count).map {_ =>
        val randomIndex = random.nextInt(characters.length)
        characters(randomIndex)
      }.mkString("")

      println(s"Valor Gerado: $generatedChars\n")
    } else if (count <= 0) {
      println("A quantidade necessita ser um número positivo")
    } else {
      println("Sem caractere disponível para gerar.")
    }
  }

  def main(args: Array[String]): Unit = {
      
    print("\nDeseja incluir letras maiúsculas? (s/n): ")
    val includeUp = readLine().trim.toLowerCase == "s"

    print("Deseja incluir letras minúsculas? (s/n): ")
    val includeLc = readLine().trim.toLowerCase == "s"

    print("Deseja incluir números? (s/n): ")
    val includeNum = readLine().trim.toLowerCase == "s"

    print("Digite a quantidade que deseja gerar: ")
    val input = readLine()
    println()

    try {
      val count = input.toInt
      val characters = genCharacters(includeUp, includeLc, includeNum)
      randomCharacters(count, characters)
    } catch {
      case e: NumberFormatException =>
        println("ERRO: O valor digitado não é um número.")
    }
  }
}

