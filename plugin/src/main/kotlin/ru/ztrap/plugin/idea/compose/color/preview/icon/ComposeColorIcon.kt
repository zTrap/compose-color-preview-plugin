@file:Suppress("DEPRECATION")

package ru.ztrap.plugin.idea.compose.color.preview.icon

import com.intellij.ui.JBColor
import com.intellij.ui.paint.RectanglePainter
import com.intellij.ui.scale.JBUIScale.scale
import com.intellij.util.ui.EmptyIcon
import com.intellij.util.ui.GraphicsUtil
import com.intellij.util.ui.ImageUtil
import com.jetbrains.rd.swing.fillRect
import java.awt.Color
import java.awt.Component
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.Paint
import java.awt.Rectangle
import java.awt.RenderingHints
import java.awt.TexturePaint
import java.awt.image.BufferedImage
import org.jetbrains.plugins.notebooks.visualization.use

internal class ComposeColorIcon : EmptyIcon {
    private val colors: Array<out Color>

    constructor(size: Int, vararg colors: Color) : super(size, size) {
        this.colors = colors
    }

    constructor(icon: ComposeColorIcon) : super(icon) {
        this.colors = icon.colors
    }

    companion object {
        private val CHESS: TexturePaint

        init {
            val iconSize = scale(12)
            val squaresBySide = 4
            val squareSize = iconSize / squaresBySide
            val chessImage = ImageUtil.createImage(iconSize, iconSize, BufferedImage.TYPE_INT_RGB)
            chessImage.createGraphics().use {
                it.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF)

                val rectangle = Rectangle(squareSize, squareSize)
                var currentColor = JBColor.LIGHT_GRAY

                fun switchColor() {
                    currentColor = if (currentColor == JBColor.LIGHT_GRAY) JBColor.GRAY else JBColor.LIGHT_GRAY
                }

                repeat(squaresBySide) { row ->
                    repeat(squaresBySide) { column ->
                        rectangle.setLocation(column * squareSize, row * squareSize)
                        it.fillRect(rectangle, currentColor)
                        switchColor()
                    }
                    switchColor()
                }
            }
            CHESS = TexturePaint(chessImage, Rectangle(iconSize, iconSize))
        }
    }

    override fun copy(): ComposeColorIcon = ComposeColorIcon(this)

    override fun paintIcon(component: Component, g: Graphics, x: Int, y: Int) {
        val graphics = g.create() as Graphics2D
        val config = GraphicsUtil.setupAAPainting(graphics)

        try {
            val w = iconWidth
            val h = iconHeight

            when (colors.size) {
                1 -> graphics.fillRect(x, y, w, h, CHESS, colors[0])
                2 -> {
                    graphics.fillPolygon(intArrayOf(x, x + w, x), intArrayOf(y, y, y + h), CHESS, colors[0])
                    graphics.fillPolygon(intArrayOf(x + w, x + w, x), intArrayOf(y, y + h, y + h), CHESS, colors[1])
                }

                else -> for (i in colors.indices) {
                    graphics.fillRect(i, x, y, w, h, CHESS, colors[i])
                    if (i == 3) break
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            graphics.dispose()
        } finally {
            config.restore()
        }
    }

    private fun Graphics2D.fillRect(i: Int, x: Int, y: Int, w: Int, h: Int, vararg colors: Paint) {
        colors.forEach {
            paint = it
            RectanglePainter.FILL.paint(
                /* g = */ this,
                /* x = */ if (i % 2 == 0) x else x + w / 2 + 1,
                /* y = */ if (i < 2) y else y + h / 2 + 1,
                /* width = */ w / 2 - 1,
                /* height = */ h / 2 - 1,
                /* object = */ null,
            )
        }
    }

    private fun Graphics2D.fillRect(x: Int, y: Int, width: Int, height: Int, vararg colors: Paint) {
        colors.forEach {
            paint = it
            fillRect(x, y, width, height)
        }
    }

    private fun Graphics2D.fillPolygon(xPoints: IntArray, yPoints: IntArray, vararg colors: Paint) {
        colors.forEach {
            paint = it
            fillPolygon(xPoints, yPoints, 3)
        }
    }

    override fun equals(other: Any?): Boolean {
        return this === other ||
                super.equals(other) &&
                other is ComposeColorIcon &&
                iconWidth == other.iconWidth &&
                iconHeight == other.iconHeight &&
                colors.contentEquals(other.colors)
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + colors.contentHashCode()
        return result
    }
}