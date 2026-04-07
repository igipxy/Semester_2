public class TopStudents11 {
    Student11[] listStudent = new Student11[5];
    int idx;
    
    public void add(Student11 std) {
        if (idx < listStudent.length) {
            listStudent[idx] = std;
            idx++;
        } else {
            System.out.println("List is full!");
        }
    }
    
    public void print() {
        for (int i = 0; i < idx; i++) {
            listStudent[i].print();
        }
    }
    
    public void bubbleSort() {
        for (int i = 0; i < idx - 1; i++) {
            for (int j = 0; j < idx - i - 1; j++) {
                if (listStudent[j].gpa < listStudent[j + 1].gpa) {
                    Student11 temp = listStudent[j];
                    listStudent[j] = listStudent[j + 1];
                    listStudent[j + 1] = temp;
                }
            }
        }
    }
    
    public void selectionSort() {
        for (int i = 0; i < idx - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < idx; j++) {
                if (listStudent[j].gpa < listStudent[minIdx].gpa) {
                    minIdx = j;
                }
            }
            Student11 temp = listStudent[minIdx];
            listStudent[minIdx] = listStudent[i];
            listStudent[i] = temp;
        }
    }
    
    public void insertionSort() {
        for (int i = 1; i < idx; i++) {
            Student11 temp = listStudent[i];
            int j = i - 1;
            while (j >= 0 && listStudent[j].gpa > temp.gpa) {
                listStudent[j + 1] = listStudent[j];
                j--;
            }
            listStudent[j + 1] = temp;
        }
    }
    
    public void insertionSortDescending() {
        for (int i = 1; i < idx; i++) {
            Student11 temp = listStudent[i];
            int j = i - 1;
            while (j >= 0 && listStudent[j].gpa < temp.gpa) {
                listStudent[j + 1] = listStudent[j];
                j--;
            }
            listStudent[j + 1] = temp;
        }
    }
}