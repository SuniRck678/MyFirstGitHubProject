package DriverFactory;

import org.testng.Reporter;
import org.testng.annotations.Test;


import commonFunctions.FunctionalLibrary;
import utilities.ExcelFileUtil;


public class DriverScript {
	 String inputpath ="D\\selenium.8oclockBatch\\Hybrid_FrameWorkbatch\\TestInput\\HybridTest.xlsx";
     String outputpath="D\\selenium.8oclockBatch\\DDT_FrameWorkbatch\\TestOutput\\HybridResults.xlsx";
     String TCSheet ="MasterTestCases";
     String TCSheet1 ="TestSteps";
     @Test
     public void startTest() throws Throwable
     {
    	 boolean res=false;
    	 String tcres="";
    	 //create object for excel file util
    	 ExcelFileUtil xl = new ExcelFileUtil(inputpath);     
    	 //count no of rows in both sheets
    	 int TCCount = xl.rowCount(TCSheet);
    	 int TSCount = xl.rowCount(TCSheet);
    	 Reporter.log(TCCount+"     "+TSCount,true);
    	 //iterate all rows in TCSheet
    	 for(int i=1;i<=TCCount;i++)
    	 {
    		 String executionstatus =xl.getCelldata(TCSheet, i, 2);
 			if(executionstatus.equalsIgnoreCase("Y"))
 			{
 				//read tcid cell
 				String tcid = xl.getCelldata(TCSheet, i, 0);
 				for(int j=1;j<=TSCount;j++)
 				{
 					String tsid =xl.getCelldata(TCSheet, j, 0);
 					if(tcid.equalsIgnoreCase(tsid)) 
 					{
 					String keyword =xl.getCelldata(TCSheet, j, 3);
 					if(keyword.equalsIgnoreCase("AdminLogin"))
 					{
 						String Para1 =xl.getCelldata(TCSheet, j, 5);
 						String Para2 =xl.getCelldata(TCSheet, j, 6);
 						res = FunctionalLibrary.verifyLogin(Para1, Para2);
 					}
 					else if(keyword.equalsIgnoreCase("NewBranch"))
 					{
 						String Para1 =xl.getCelldata(TCSheet, j, 5);
 						String Para2 =xl.getCelldata(TCSheet, j, 6);
 						String Para3 =xl.getCelldata(TCSheet, j, 7);
 						String Para4 =xl.getCelldata(TCSheet, j, 8);
 						String Para5 =xl.getCelldata(TCSheet, j, 9);
 						String Para6 =xl.getCelldata(TCSheet, j, 10);
 						String Para7 =xl.getCelldata(TCSheet, j, 11);
 						String Para8 =xl.getCelldata(TCSheet, j, 12);
 						String Para9 =xl.getCelldata(TCSheet, j, 13);
 						FunctionalLibrary.clickBranches();
 						res = FunctionalLibrary.verifynewBranch(Para1, Para2, Para3, Para4, Para5, Para6, Para7, Para8, Para9);
 						
 					}
 					else if(keyword.equalsIgnoreCase("BranchUpdate"))
 					{
 						String Para1 =xl.getCelldata(TCSheet, j, 5);
 						String Para2 =xl.getCelldata(TCSheet, j, 6);
 						String Para6 =xl.getCelldata(TCSheet, j, 10);
 						FunctionalLibrary.clickBranches();
 						res =FunctionalLibrary.verifyBranchUpdate(Para1, Para2, Para6);
 					}
 					else if(keyword.equalsIgnoreCase("AdminLogout"))
 					{
 						res =FunctionalLibrary.verifyLogout();
 					}
 					String tsres="";
 					if(res)
 					{
 						tsres="pass";
 						xl.setCellData(TCSheet, j, 4, tsres, outputpath);
 					}
 					else
 					{
 						tsres="Fail";
 						xl.setCellData(TCSheet, j, 4, tsres, outputpath);
 					}
 					tcres=tsres;
 					
 					}
 				}
 				xl.setCellData(TCSheet, i, 3, tcres, outputpath);
 			}
 			else
 			{
 				//which are flag to N write as blocked in TCSheet
 				xl.setCellData(TCSheet, i, 3, "Blocked", outputpath);
 			}
 		}
 	}

 }

