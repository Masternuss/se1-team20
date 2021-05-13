package exercise2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringSortImpl implements StringSortIF {

    String[][] dependencies = null;

    public StringSortImpl(String[][] dependencies) {
        this.dependencies = dependencies;
    }

    public boolean isWellSorted(String[] sequence) {

        //Result Array to compare two hierarchies
        int[] res = new int[2];

        // Create Set for unique Strings
        Set<String> setofsequence = new HashSet<String>(Arrays.asList(sequence));
        // Same Strings are not valid as Arguments
        if (sequence.length != setofsequence.size()) throw new IllegalArgumentException();

        Set<String> setofdependencies = new HashSet<String>();

        for (int i=0; i<dependencies.length; i++) {
            setofdependencies.add(dependencies[i][0]);
            setofdependencies.add(dependencies[i][1]);
        }
        // Use of "retainAll" -> if Elements are not in specified Colleciton: remove = true
        if ((setofsequence.retainAll(setofdependencies))) throw new IllegalArgumentException();

        //For Loop to get Single Arrays
        for (int i=0; i<dependencies.length; i++) {
            //For Loop to give Values to res[] based on x
            for (int x=0; x<sequence.length; x++){
                if (dependencies[i][0] == sequence[x]) res[0] = x;
                if (dependencies[i][1] == sequence[x]) res[1] = x;
            }
            //Compare both string values
            if (res[0]>res[1]) return false;
        }

        return true;
    }

}
