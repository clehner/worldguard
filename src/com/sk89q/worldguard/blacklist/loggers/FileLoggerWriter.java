// $Id$
/*
 * WorldGuard
 * Copyright (C) 2010 sk89q <http://www.sk89q.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

package com.sk89q.worldguard.blacklist.loggers;

import java.io.*;

/**
 *
 * @author sk89q
 */
public class FileLoggerWriter implements Comparable<FileLoggerWriter> {
    /**
     * Path.
     */
    public String path;
    /**
     * Writer.
     */
    private BufferedWriter writer;
    /**
     * Last use.
     */
    private long lastUse;

    /**
     * Construct the object.
     * 
     * @param path 
     * @param writer
     */
    public FileLoggerWriter(String path, BufferedWriter writer) {
        this.path = path;
        this.writer = writer;
        lastUse = System.currentTimeMillis();
    }

    /**
     * File path.
     * 
     * @return
     */
    public String getPath() {
        return path;
    }

    /**
     * @return the writer
     */
    public BufferedWriter getWriter() {
        return writer;
    }

    /**
     * @return the lastUse
     */
    public long getLastUse() {
        return lastUse;
    }
    
    /**
     * Update last use time.
     */
    public void updateLastUse() {
        lastUse = System.currentTimeMillis();
    }

    /**
     * Comparison function.
     * 
     * @param other
     * @return
     */
    public int compareTo(FileLoggerWriter other) {
        if (lastUse > other.lastUse) {
            return 1;
        } else if (lastUse < other.lastUse) {
            return -1;
        } else {
            return 0;
        }
    }
}
