import java.io.*;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class FileProcessor {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String path = sc.nextLine();
        System.out.print("Enter start row: ");
        int startRow = sc.nextInt();
        sc.close();

        if (path.endsWith(".csv")) readCSV(path, startRow);
        else readExcel(path, startRow);
    }

    static void readCSV(String path, int startRow) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        for (int i = 1; i < startRow; i++) br.readLine();
        String line;
        while ((line = br.readLine()) != null) System.out.println(line);
        br.close();
    }

    static void readExcel(String path, int startRow) throws Exception {
        Workbook wb = path.endsWith(".xls") ? new HSSFWorkbook(new FileInputStream(path)) : new XSSFWorkbook(new FileInputStream(path));
        for (Row row : wb.getSheetAt(0)) {
            if (row.getRowNum() + 1 >= startRow) {
                for (Cell cell : row) System.out.print(cell + "\t");
                System.out.println();
            }
        }
        wb.close();
    }
}
