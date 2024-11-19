package ru.ztrap.plugin.idea.compose.color.preview.icon

import com.intellij.ui.JBColor
import com.intellij.ui.paint.RectanglePainter
import com.intellij.ui.scale.JBUIScale
import com.intellij.ui.scale.JBUIScale.scale
import com.intellij.util.ui.GraphicsUtil
import com.intellij.util.ui.ImageUtil
import com.intellij.util.ui.JBCachingScalableIcon
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

internal class ComposeColorIcon : JBCachingScalableIcon<ComposeColorIcon> {
    private val size: Int
    private val colors: Array<out Color>

    constructor(size: Int, vararg colors: Color) {
        this.size = size
        this.colors = colors
    }

    constructor(icon: ComposeColorIcon) : super(icon) {
        this.size = icon.size
        this.colors = icon.colors
    }

    init {
        JBUIScale.addUserScaleChangeListener { clearCachedScaledValue() }
    }

    companion object {
        private val CHESS: TexturePaint

        init {
            val iconSize = scale(12)
            val squaresBySide = 4
            val squareSize = iconSize / squaresBySide
            val chessImage = ImageUtil.createImage(iconSize, iconSize, BufferedImage.TYPE_INT_RGB)
            chessImage.createGraphics().let {
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

                it.dispose()
            }
            CHESS = TexturePaint(chessImage, Rectangle(iconSize, iconSize))
        }
    }

    override fun getIconWidth(): Int = size
    override fun getIconHeight(): Int = size
    override fun copy(): ComposeColorIcon = ComposeColorIcon(this).also { it.updateContextFrom(this) }

    override fun paintIcon(component: Component, g: Graphics, x: Int, y: Int) {
        val graphics = g.create() as Graphics2D
        val config = GraphicsUtil.setupAAPainting(graphics)

        try {
            when (colors.size) {
                1 -> graphics.fillRect(x, y, size, CHESS, colors.component1())
                2 -> {
                    graphics.fillTriangle(
                        xPoints = intArrayOf(x, x + size, x),
                        yPoints = intArrayOf(y, y, y + size),
                        colors = arrayOf(CHESS, colors.component1()),
                    )
                    graphics.fillTriangle(
                        xPoints = intArrayOf(x + size, x + size, x),
                        yPoints = intArrayOf(y, y + size, y + size),
                        colors = arrayOf(CHESS, colors.component2())
                    )
                }

                else -> for (index in colors.indices) {
                    graphics.fillRect(index, x, y, size, CHESS, colors[index])
                    if (index == 3) break
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            graphics.dispose()
        } finally {
            config.restore()
        }
    }

    private fun Graphics2D.fillRect(index: Int, x: Int, y: Int, size: Int, vararg colors: Paint) {
        colors.forEach {
            paint = it
            RectanglePainter.FILL.paint(
                /* g = */ this,
                /* x = */ if (index % 2 == 0) x else x + size / 2 + 1,
                /* y = */ if (index < 2) y else y + size / 2 + 1,
                /* width = */ size / 2 - 1,
                /* height = */ size / 2 - 1,
                /* object = */ null,
            )
        }
    }

    private fun Graphics2D.fillRect(x: Int, y: Int, size: Int, vararg colors: Paint) {
        colors.forEach {
            paint = it
            fillRect(x, y, size, size)
        }
    }

    private fun Graphics2D.fillTriangle(xPoints: IntArray, yPoints: IntArray, vararg colors: Paint) {
        colors.forEach {
            paint = it
            fillPolygon(xPoints, yPoints, 3)
        }
    }

    override fun equals(other: Any?): Boolean {
        return this === other ||
                other is ComposeColorIcon &&
                size == other.size &&
                colors.contentEquals(other.colors)
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + size.hashCode()
        result = 31 * result + colors.contentHashCode()
        return result
    }
}