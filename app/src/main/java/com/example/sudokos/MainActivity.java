package com.example.sudokos;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static int N = 9;
    EditText[][] grid = new EditText[9][9];
    int[][] matrix = new int[9][9];
    Button clear;
    Button credits;

    Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        BindingOfGrid(grid);

        calculate=findViewById(R.id.calculate);
        clear = findViewById(R.id.clear);
        credits = findViewById(R.id.credits);


        calculate.setOnClickListener(view -> {
            try {
                for(int i=0;i<9;i++){
                    for(int j=0;j<9;j++){
                        matrix[i][j]=Integer.parseInt(String.valueOf(grid[i][j].getText()));
                    }
                }
                if (solveSudoku(matrix, 0, 0)) {
                    print(grid);
                }
                else{
                    Toast.makeText(getApplicationContext()," Invalid Sudoko" ,Toast.LENGTH_SHORT).show();
                }
            }
            catch(Exception e){
                Toast.makeText(getApplicationContext(),e.toString() ,Toast.LENGTH_SHORT).show();
            }
        });

        clear.setOnClickListener(view -> {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9 ; j++) {
                    matrix[i][j]=0;
                    grid[i][j].setText("0");
                }

            }
        });
        credits.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(),"Charan Teja -072 \n Shhreyya Sri -076",Toast.LENGTH_LONG).show();
        });




    }
    void print(EditText[][] grid){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                grid[i][j].setText(String.valueOf(matrix[i][j]));
            }
        }

    }
    void BindingOfGrid(EditText[][] matrix){
        matrix[0][0] = findViewById(R.id.box00);
        matrix[0][1] = findViewById(R.id.box01);
        matrix[0][2] = findViewById(R.id.box02);
        matrix[0][3] = findViewById(R.id.box03);
        matrix[0][4] = findViewById(R.id.box04);
        matrix[0][5] = findViewById(R.id.box05);
        matrix[0][6] = findViewById(R.id.box06);
        matrix[0][7] = findViewById(R.id.box07);
        matrix[0][8] = findViewById(R.id.box08);
        matrix[1][0] = findViewById(R.id.box10);
        matrix[1][1] = findViewById(R.id.box11);
        matrix[1][2] = findViewById(R.id.box12);
        matrix[1][3] = findViewById(R.id.box13);
        matrix[1][4] = findViewById(R.id.box14);
        matrix[1][5] = findViewById(R.id.box15);
        matrix[1][6] = findViewById(R.id.box16);
        matrix[1][7] = findViewById(R.id.box17);
        matrix[1][8] = findViewById(R.id.box18);
        matrix[2][0] = findViewById(R.id.box20);
        matrix[2][1] = findViewById(R.id.box21);
        matrix[2][2] = findViewById(R.id.box22);
        matrix[2][3] = findViewById(R.id.box23);
        matrix[2][4] = findViewById(R.id.box24);
        matrix[2][5] = findViewById(R.id.box25);
        matrix[2][6] = findViewById(R.id.box26);
        matrix[2][7] = findViewById(R.id.box27);
        matrix[2][8] = findViewById(R.id.box28);
        matrix[3][0] = findViewById(R.id.box30);
        matrix[3][1] = findViewById(R.id.box31);
        matrix[3][2] = findViewById(R.id.box32);
        matrix[3][3] = findViewById(R.id.box33);
        matrix[3][4] = findViewById(R.id.box34);
        matrix[3][5] = findViewById(R.id.box35);
        matrix[3][6] = findViewById(R.id.box36);
        matrix[3][7] = findViewById(R.id.box37);
        matrix[3][8] = findViewById(R.id.box38);
        matrix[4][0] = findViewById(R.id.box40);
        matrix[4][1] = findViewById(R.id.box41);
        matrix[4][2] = findViewById(R.id.box42);
        matrix[4][3] = findViewById(R.id.box43);
        matrix[4][4] = findViewById(R.id.box44);
        matrix[4][5] = findViewById(R.id.box45);
        matrix[4][6] = findViewById(R.id.box46);
        matrix[4][7] = findViewById(R.id.box47);
        matrix[4][8] = findViewById(R.id.box48);
        matrix[5][0] = findViewById(R.id.box50);
        matrix[5][1] = findViewById(R.id.box51);
        matrix[5][2] = findViewById(R.id.box52);
        matrix[5][3] = findViewById(R.id.box53);
        matrix[5][4] = findViewById(R.id.box54);
        matrix[5][5] = findViewById(R.id.box55);
        matrix[5][6] = findViewById(R.id.box56);
        matrix[5][7] = findViewById(R.id.box57);
        matrix[5][8] = findViewById(R.id.box58);
        matrix[6][0] = findViewById(R.id.box60);
        matrix[6][1] = findViewById(R.id.box61);
        matrix[6][2] = findViewById(R.id.box62);
        matrix[6][3] = findViewById(R.id.box63);
        matrix[6][4] = findViewById(R.id.box64);
        matrix[6][5] = findViewById(R.id.box65);
        matrix[6][6] = findViewById(R.id.box66);
        matrix[6][7] = findViewById(R.id.box67);
        matrix[6][8] = findViewById(R.id.box68);
        matrix[7][0] = findViewById(R.id.box70);
        matrix[7][1] = findViewById(R.id.box71);
        matrix[7][2] = findViewById(R.id.box72);
        matrix[7][3] = findViewById(R.id.box73);
        matrix[7][4] = findViewById(R.id.box74);
        matrix[7][5] = findViewById(R.id.box75);
        matrix[7][6] = findViewById(R.id.box76);
        matrix[7][7] = findViewById(R.id.box77);
        matrix[7][8] = findViewById(R.id.box78);
        matrix[8][0] = findViewById(R.id.box80);
        matrix[8][1] = findViewById(R.id.box81);
        matrix[8][2] = findViewById(R.id.box82);
        matrix[8][3] = findViewById(R.id.box83);
        matrix[8][4] = findViewById(R.id.box84);
        matrix[8][5] = findViewById(R.id.box85);
        matrix[8][6] = findViewById(R.id.box86);
        matrix[8][7] = findViewById(R.id.box87);
        matrix[8][8] = findViewById(R.id.box88);
    }
    static boolean solveSudoku(int grid[][], int row,int col){

		/*if we have reached the 8th
		row and 9th column (0
		indexed matrix) ,
		we are returning true to avoid further
		backtracking	 */
        if (row == N - 1 && col == N)
            return true;

        // Check if column value becomes 9 ,
        // we move to next row
        // and column start from 0
        if (col == N) {
            row++;
            col = 0;
        }

        // Check if the current position
        // of the grid already
        // contains value >0, we iterate
        // for next column
        if (grid[row][col] != 0)
            return solveSudoku(grid, row, col + 1);

        for (int num = 1; num < 10; num++) {

            // Check if it is safe to place
            // the num (1-9) in the
            // given row ,col ->we move to next column
            if (isSafe(grid, row, col, num)) {

				/* assigning the num in the current
				(row,col) position of the grid and
				assuming our assigned num in the position
				is correct */
                grid[row][col] = num;

                // Checking for next
                // possibility with next column
                if (solveSudoku(grid, row, col + 1))
                    return true;
            }
			/* removing the assigned num , since our
			assumption was wrong , and we go for next
			assumption with diff num value */
            grid[row][col] = 0;
        }
        return false;
    }
    static boolean isSafe(int[][] grid, int row, int col,int num){


        // Check if we find the same num
        // in the similar row , we
        // return false
        for (int x = 0; x <= 8; x++)
            if (grid[row][x] == num)
                return false;

        // Check if we find the same num
        // in the similar column ,
        // we return false
        for (int x = 0; x <= 8; x++)
            if (grid[x][col] == num)
                return false;

        // Check if we find the same num
        // in the particular 3*3
        // matrix, we return false
        int startRow = row - row % 3, startCol
                = col - col % 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i + startRow][j + startCol] == num)
                    return false;

        return true;
    }


}