import org.scalatest.{Matchers, FunSuite}

/** @version 1.4.0 */
class PangramTest extends FunSuite with Matchers {

  test("sentence empty") {
    Pangrams.isPangram("") should be (false)
  }

  test("recognizes a perfect lower case pangram") {

    Pangrams.isPangram("abcdefghijklmnopqrstuvwxyz") should be (true)
  }

  test("pangram with only lower case") {

    Pangrams.isPangram("the quick brown fox jumps over the lazy dog") should be (true)
  }

  test("missing character 'x'") {

    Pangrams.isPangram("a quick movement of the enemy will jeopardize five gunboats") should be (false)
  }

  test("another missing character, e.g. 'h'") {

    Pangrams.isPangram("five boxing wizards jump quickly at it") should be (false)
  }

  test("pangram with underscores") {

    Pangrams.isPangram("the_quick_brown_fox_jumps_over_the_lazy_dog") should be (true)
  }

  test("pangram with numbers") {

    Pangrams.isPangram("the 1 quick brown fox jumps over the 2 lazy dogs") should be (true)
  }

  test("missing letters replaced by numbers") {

    Pangrams.isPangram("7h3 qu1ck brown fox jumps ov3r 7h3 lazy dog") should be (false)
  }

  test("pangram with mixed case and punctuation") {

    Pangrams.isPangram(""""Five quacking Zephyrs jolt my wax bed."""") should be (true)
  }

  test("upper and lower case versions of the same character should not be counted separately") {

    Pangrams.isPangram("the quick brown fox jumps over with lazy FX") should be (false)
  }
}
