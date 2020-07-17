package com.example.psgetdegrees.assessmentProvider;

import androidx.room.ColumnInfo;

/**
 * An class that represents a subset of columns from the assessments database.
 * This class is used when we want to retrieve the value column and the mark column.
 */
public class AssessmentValue {
    @ColumnInfo(name = "value")
    public String value;

    @ColumnInfo(name = "mark")
    public String mark;
}
