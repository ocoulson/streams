package streams

import org.scalatest.FunSuite


/**
  * Created by Oliver Coulson on 30/07/2017.
  */
class OllieSuite extends FunSuite with StringParserTerrain{

    val level =
      """ST
        |oo
        |oo""".stripMargin

  override lazy val startPos: Pos = Pos(0, 0)
  override lazy val goal: Pos = Pos(0, 1)
  val illegalPos: Pos = Pos(2, 2)
  var legalStandingBlock: Block = Block(startPos, startPos)
  var legalNotStandingBlock: Block = Block(startPos, goal)
  test("TerrainFunction") {


    assert(terrain(startPos))
    assert(terrain(goal))
    assert(terrain(Pos(1,0)))
    assert(terrain(Pos(1,1)))
    assert(terrain(Pos(2,0)))
    assert(terrain(Pos(2,1)))


    assert(!terrain(illegalPos))
  }

  test("IsStanding") {
    assert(legalStandingBlock.isStanding)
    assert(!legalNotStandingBlock.isStanding)
  }

  test("IsLegal") {
    var illegalStandingBlock = Block(illegalPos,illegalPos)
    var illegalNonStandingBlock = Block(illegalPos,illegalPos.deltaCol(1))


    assert(legalStandingBlock.isLegal)
    assert(legalNotStandingBlock.isLegal)
    assert(!illegalStandingBlock.isLegal)
    assert(!illegalNonStandingBlock.isLegal)
  }


  

}
