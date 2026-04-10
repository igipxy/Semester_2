public class SearchStudent11 {
    Students11[] listStd;
    int idx;

    // Constructor modified to accept dynamic size for flexibility 
    public SearchStudent11(int size) {
        listStd = new Students11[size];
        idx = 0;
    }

    // Method to add a student to the array [cite: 24]
    public void add(Students11 std) {
        if (idx < listStd.length) {
            listStd[idx] = std;
            idx++;
        } else {
            System.out.println("Data is already full!");
        }
    }

    // Method to display all students using a foreach loop [cite: 26, 27]
    public void display() {
        for (Students11 student : listStd) {
            if (student != null) { // Prevents errors if the array isn't completely full
                student.display();
                System.out.println("------------------------------------");
            }
        }
    }

    // Sequential Search Algorithm 
    public int findSeqSearch(int search) {
        int position = -1; // Default if not found
        for (int i = 0; i < listStd.length; i++) {
            if (listStd[i] != null && listStd[i].nim == search) {
                position = i;
                break;
            }
        }
        return position;
    }

    // Binary Search Algorithm [cite: 50, 51]
    public int findBinarySearch(int cari, int left, int right) {
        int mid;
        if (right >= left) {
            mid = (left + right) / 2;
            if (cari == listStd[mid].nim) {
                return mid;
            } else if (listStd[mid].nim > cari) {
                return findBinarySearch(cari, left, mid - 1);
            } else {
                return findBinarySearch(cari, mid + 1, right);
            }
        }
        return -1;
    }

    // Prints just the index position 
    public void showPosition(int x, int pos) {
        if (pos != -1) {
            System.out.println("Data : " + x + " is found in index-" + pos);
        } else {
            System.out.println("Data : " + x + " is not found");
        }
    }

    // Prints the full data of the found student 
    public void showData(int x, int pos) {
        if (pos != -1) {
            System.out.println("NIM \t : " + x);
            System.out.println("Name \t : " + listStd[pos].name);
            System.out.println("Age \t : " + listStd[pos].age);
            System.out.println("GPA \t : " + listStd[pos].gpa);
        } else {
            System.out.println("Data " + x + " is not found");
        }
    }
}