import org.scalatest.{Matchers, FunSuite}

/** @version 1.1.0 */
class RaindropsTest extends FunSuite with Matchers {
  
  test("the sound for 1 is 1") {
    Raindrops.convert(1) should be ("1")
  }

  test("the sound for 3 is Pling") {

    Raindrops.convert(3) should be ("Pling")
  }

  test("the sound for 5 is Plang") {

    Raindrops.convert(5) should be ("Plang")
  }

  test("the sound for 7 is Plong") {

    Raindrops.convert(7) should be ("Plong")
  }

  test("the sound for 6 is Pling as it has a factor 3") {

    Raindrops.convert(6) should be ("Pling")
  }

  test("2 to the power 3 does not make a raindrop sound as 3 is the exponent not the base") {

    Raindrops.convert(8) should be ("8")
  }

  test("the sound for 9 is Pling as it has a factor 3") {

    Raindrops.convert(9) should be ("Pling")
  }

  test("the sound for 10 is Plang as it has a factor 5") {

    Raindrops.convert(10) should be ("Plang")
  }

  test("the sound for 14 is Plong as it has a factor of 7") {

    Raindrops.convert(14) should be ("Plong")
  }

  test("the sound for 15 is PlingPlang as it has factors 3 and 5") {

    Raindrops.convert(15) should be ("PlingPlang")
  }

  test("the sound for 21 is PlingPlong as it has factors 3 and 7") {

    Raindrops.convert(21) should be ("PlingPlong")
  }

  test("the sound for 25 is Plang as it has a factor 5") {

    Raindrops.convert(25) should be ("Plang")
  }

  test("the sound for 27 is Pling as it has a factor 3") {

    Raindrops.convert(27) should be ("Pling")
  }

  test("the sound for 35 is PlangPlong as it has factors 5 and 7") {

    Raindrops.convert(35) should be ("PlangPlong")
  }

  test("the sound for 49 is Plong as it has a factor 7") {

    Raindrops.convert(49) should be ("Plong")
  }

  test("the sound for 52 is 52") {

    Raindrops.convert(52) should be ("52")
  }

  test("the sound for 105 is PlingPlangPlong as it has factors 3, 5 and 7") {

    Raindrops.convert(105) should be ("PlingPlangPlong")
  }

  test("the sound for 3125 is Plang as it has a factor 5") {

    Raindrops.convert(3125) should be ("Plang")
  }
}
