public class StringSortImpl implements StringSortIF {

    String[][] dependencies = null;

    public StringSortImpl(String[][] dependencies) {
        this.dependencies = dependencies;
    }

    public boolean isWellSorted(String[] sequence) {

        //Result Array to compare two hierarchies
        int[] res = new int[2];

        //int[] MengeDerAbhängigkeiten = new int[]

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
