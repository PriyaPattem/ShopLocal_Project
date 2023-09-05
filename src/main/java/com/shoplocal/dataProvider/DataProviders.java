package com.shoplocal.dataProvider;

import com.shoplocal.utility.NewExcelLibrary;

public class DataProviders {
    NewExcelLibrary obj = new NewExcelLibrary();

   //Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest, orderHistoryandDetailsTest

    public Object[][] getData(){
        int rowsCount = obj.getRowCount("RegistrationData");
        int columnsCount = obj.getColumnCount("RegistrationData");
        int actRowsCount = rowsCount-1;

        Object[][] data = new Object[actRowsCount][columnsCount];

        for(int i=0; i<actRowsCount; i++){
            for(int j=0; j<columnsCount; j++){
                data[i][j] = obj.getCellData("LoginData",j,i+2);
            }
        }
        return data;
    }


}
