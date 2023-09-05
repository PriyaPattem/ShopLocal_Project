package com.shoplocal.dataProvider;

import com.shoplocal.utility.NewExcelLibrary;
import org.testng.annotations.DataProvider;

public class DataProviders {
    NewExcelLibrary obj = new NewExcelLibrary();

   //Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest, orderHistoryandDetailsTest

    @DataProvider(name = "CustomerLoginData")
    public Object[][] getLoginData(){
        int rowsCount = obj.getRowCount("CustomerLoginData");
        int columnsCount = obj.getColumnCount("CustomerLoginData");
        int actRowsCount = rowsCount-1;
        Object[][] data = new Object[actRowsCount][columnsCount];

        for(int i=0; i<actRowsCount; i++){
            for(int j=0; j<columnsCount; j++){
                data[i][j] = obj.getCellData("CustomerLoginData",j,i+2);
            }
        }
        return data;
    }
    @DataProvider(name="AddressData")
    public Object[][] getAddressData(){
        int rowsCount = obj.getRowCount("AddressData");
        int columnsCount = obj.getColumnCount("AddressData");
        int actRowsCount = rowsCount-1;
        Object[][] data = new Object[actRowsCount][columnsCount];

        for(int i=0; i<actRowsCount; i++){
            for(int j=0; j<columnsCount; j++){
                data[i][j] = obj.getCellData("AddressData",j,i+2);
            }
        }
        return data;
    }

    @DataProvider(name="CardDetailsData")
    public Object[][] getCardDetailsData(){
        int rowsCount = obj.getRowCount("CardDetailsData");
        int columnsCount = obj.getColumnCount("CardDetailsData");
        int actRowsCount = rowsCount-1;
        Object[][] data = new Object[actRowsCount][columnsCount];

        for(int i=0; i<actRowsCount; i++){
            for(int j=0; j<columnsCount; j++){
                data[i][j] = obj.getCellData("CardDetailsData",j,i+2);
            }
        }
        return data;
    }




}
