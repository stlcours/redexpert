package org.underworldlabs.swing.layouts;

import javax.swing.*;
import java.awt.*;

public class GridBagHelper {
    // координаты текущей ячейки
    // настраиваемый объект GridBagConstraints
    private GridBagConstraints constraints;
    private GridBagConstraints defaultConstraints;

    public GridBagHelper() {
        this.constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        defaultConstraints = new GridBagConstraints();
    }

    // возвращает настроенный объект GridBagConstraints
    public GridBagConstraints get() {
        return constraints;
    }

    public GridBagHelper setDefaults(GridBagConstraints defaultConstraints) {
        this.defaultConstraints = defaultConstraints;
        return this;
    }

    public GridBagHelper defaults() {
        constraints.fill = defaultConstraints.fill;
        constraints.anchor = defaultConstraints.anchor;
        constraints.weightx = defaultConstraints.weightx;
        constraints.weighty = defaultConstraints.weighty;
        constraints.gridheight = defaultConstraints.gridheight;
        constraints.gridwidth = defaultConstraints.gridwidth;
        constraints.insets = defaultConstraints.insets;
        constraints.ipadx = defaultConstraints.ipadx;
        constraints.ipadx = defaultConstraints.ipady;
        return this;
    }

    // двигается на следующую ячейку
    public GridBagHelper nextCol() {
        constraints.gridx++;
        // для удобства возвращаем себя
        return this;
    }

    // двигается на следующий ряд
    public GridBagHelper nextRowFirstCol() {
        constraints.gridy++;
        constraints.gridx = 0;
        return this;
    }

    public GridBagHelper nextRow() {
        constraints.gridy++;
        return this;
    }

    public GridBagHelper setXY(int x, int y) {
        constraints.gridx = x;
        constraints.gridy = y;
        return this;
    }

    // раздвигает ячейку до конца строки
    public GridBagHelper spanX() {
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.weightx = 1;
        return this;
    }

    // заполняет ячейку по горизонтали
    public GridBagHelper fillHorizontally() {
        constraints.fill = GridBagConstraints.HORIZONTAL;
        return this;
    }

    public GridBagHelper fillNone() {
        constraints.fill = GridBagConstraints.NONE;
        return this;
    }

    public GridBagHelper fillVertical() {
        constraints.fill = GridBagConstraints.VERTICAL;
        return this;
    }

    public GridBagHelper fillBoth() {
        constraints.fill = GridBagConstraints.BOTH;
        return this;
    }

    // вставляет распорку справа
    public GridBagHelper gap(int size) {
        constraints.insets.right = size;
        return this;
    }

    public GridBagHelper spanY() {
        constraints.gridheight = GridBagConstraints.REMAINDER;
        constraints.weighty = 1;
        return this;
    }

    public GridBagHelper setMaxWeightX() {
        constraints.weightx = 1;
        return this;
    }

    public GridBagHelper setMaxWeightY() {
        constraints.weighty = 1;
        return this;
    }

    public GridBagHelper setMinWeightX() {
        constraints.weightx = 0;
        return this;
    }

    public GridBagHelper setMinWeightY() {
        constraints.weighty = 0;
        return this;
    }

    public GridBagHelper seWeightX(double weight) {
        constraints.weightx = weight;
        return this;
    }

    public GridBagHelper setWeightY(double weight) {
        constraints.weighty = weight;
        return this;
    }

    public GridBagHelper anchorNorthWest() {
        constraints.anchor = GridBagConstraints.NORTHWEST;
        return this;
    }

    public GridBagHelper anchorNorth() {
        constraints.anchor = GridBagConstraints.NORTH;
        return this;
    }

    public GridBagHelper anchorNorthEast() {
        constraints.anchor = GridBagConstraints.NORTHEAST;
        return this;
    }

    public GridBagHelper anchorEast() {
        constraints.anchor = GridBagConstraints.EAST;
        return this;
    }

    public GridBagHelper anchorSouthEast() {
        constraints.anchor = GridBagConstraints.SOUTHEAST;
        return this;
    }

    public GridBagHelper anchorSouth() {
        constraints.anchor = GridBagConstraints.SOUTH;
        return this;
    }

    public GridBagHelper anchorSouthWest() {
        constraints.anchor = GridBagConstraints.SOUTHWEST;
        return this;
    }

    public GridBagHelper anchorWest() {
        constraints.anchor = GridBagConstraints.WEST;
        return this;
    }

    public GridBagHelper anchorCenter() {
        constraints.anchor = GridBagConstraints.CENTER;
        return this;
    }

    public GridBagHelper setAnchor(int anchor) {
        constraints.anchor = anchor;
        return this;
    }

    public GridBagHelper setInsets(int left, int top, int right, int bottom) {
        Insets i = new Insets(top, left, bottom, right);
        constraints.insets = i;
        return this;
    }

    public GridBagHelper setWeights(float horizontal, float vertical) {
        constraints.weightx = horizontal;
        constraints.weighty = vertical;
        return this;
    }

    public GridBagHelper setWidth(int width) {
        constraints.gridwidth = width;
        return this;
    }

    public GridBagHelper setHeight(int height) {
        constraints.gridheight = height;
        return this;
    }

    public GridBagHelper setIpad(int x, int y) {
        constraints.ipadx = x;
        constraints.ipady = y;
        return this;
    }

    public GridBagHelper setLabelDefault() {
        return setWidth(1).setHeight(1).setWeights(0, 0);
    }

    public void insertEmptyRow(Container c, int height) {
        Component comp = Box.createVerticalStrut(height);
        nextCol().nextRowFirstCol().fillHorizontally().spanX();
        c.add(comp, get());
        nextRowFirstCol();
    }

    public void insertEmptyFiller(Container c) {
        Component comp = Box.createGlue();
        nextCol().nextRowFirstCol().fillBoth().spanX().spanY().setWeights(1.0f, 1.0f);
        c.add(comp, get());
        nextRowFirstCol();
    }

}
