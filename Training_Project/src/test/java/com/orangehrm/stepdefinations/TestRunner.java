package com.orangehrm.stepdefinations;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions; 

@RunWith(Cucumber.class)
@CucumberOptions(features="D:\\eclipse\\Training_Project\\src\\test\\resources\\Features"
,glue= {"com.orangehrm.stepdefinations"}
,tags="@smoke"
,dryRun=false
,monochrome=true) 
public class TestRunner { 
	
}