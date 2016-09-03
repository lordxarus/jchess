package com.lordxarus.jchess.piece

/**
 * Created by jeremy on 3/13/16.
 */
enum class PieceColor(colorName : String) {

    BLACK("b"), WHITE("w");

    val colorName = colorName

    fun getModifier(color : PieceColor) : Int {
        when (color) {
            BLACK -> return 1
            WHITE -> return -1
        }
    }

    fun getOpposite(color : PieceColor) : PieceColor {
        when (color) {
                BLACK -> return WHITE
                WHITE -> return BLACK
        }
    }

}