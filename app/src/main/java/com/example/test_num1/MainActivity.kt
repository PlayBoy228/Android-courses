package com.example.test_num1
import kotlin.math.abs

fun pointTeamRandom () = (0..5).random()

fun main() {
     val teamsPoint = MatchTeams()
     var arMatch = arrayMatch()
     println(teamsPoint)
     println()
     teamsPoint.pointForTeams(2,7)
     println("Point first team:${teamsPoint.pointTeamOne}")
     println("Point second team:${teamsPoint.pointTeamTwo}")
     println()
     println("Point teams for 10 match: ")
     println(printArray(arMatch))
     println()
     println("After deleting matches with the same score:")
     println(printArray(arDeleteEqualMatch(arMatch)))
     println()
     println("Maximum spread:")
     println(pointSpread(arMatch))
}


fun arrayMatch ():ArrayList<MatchTeams> {
     val matchs = ArrayList<MatchTeams>()
     for (i in 0..9) {
          matchs.add(MatchTeams(pointTeamRandom(), pointTeamRandom()))
     }
     return matchs;
}

fun printArray(ar:ArrayList<MatchTeams> ){
    ar.forEach {println(" ${it.pointTeamOne} VS ${it.pointTeamTwo}")}
}

fun arDeleteEqualMatch(ar:ArrayList<MatchTeams>):ArrayList<MatchTeams>{
     val tempAr = ArrayList<MatchTeams>()
     ar.forEach { if (it.pointTeamOne != it.pointTeamTwo)  tempAr.add(it)  }
     return tempAr
}


fun pointSpread (ar:ArrayList<MatchTeams>) {
     val setPoint = mutableSetOf<MatchTeams>()
     var max = 0
     ar.forEach { if(abs(it.pointTeamOne - it.pointTeamTwo ) > max) max =abs(it.pointTeamOne - it.pointTeamTwo ) }
     ar.forEach { if(abs(it.pointTeamOne - it.pointTeamTwo ) == max) setPoint.add(it) }
     setPoint.forEach { println( "${it.pointTeamOne} VS ${it.pointTeamTwo}" )}
}









