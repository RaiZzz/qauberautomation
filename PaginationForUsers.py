from selenium import webdriver
import unittest
import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait
import logging
from datetime import datetime
import os

class PageNoFunctional(unittest.TestCase):
    mypath = r'C:\Users\UNI\PycharmProjects\Wave-Fits\TestSuite\Logs&Seccenshots\PaginationForUsersN'
    if not os.path.exists(mypath):
        os.makedirs(mypath)
    newtime = datetime.now().strftime("%Y%m%d%H%M%S")
    logging.basicConfig(filename='C:\Users\UNI\PycharmProjects\Wave-Fits\TestSuite\Logs&Seccenshots\PaginationForUsersN\Logs'+ newtime +'.txt',level=logging.DEBUG)
    logging.debug('debug message')
    logging.info('info message')
    logging.warn('warn message')
    logging.error('error message')
    logging.critical('critical message')
    def setUp(self):
        #self.driver = webdriver.Firefox()
        self.driver = webdriver.Chrome()
        self.driver.implicitly_wait(30)
        self.base_url = "http://www.testwave.qabidder.net/"

    def test_PageNoFunctional(self):
        driver = self.driver
        driver.get(self.base_url + "/#/page/login")
        #Enter Regular User Name
        driver.find_element_by_id("exampleInputEmail1").clear()
        driver.find_element_by_id("exampleInputEmail1").send_keys("avanireg@gmail.com")
        #Enter Associated password
        driver.find_element_by_id("exampleInputPassword1").clear()
        driver.find_element_by_id("exampleInputPassword1").send_keys("1234567")
        time.sleep(5)
        #Click Login Button
        driver.find_element_by_xpath("//button[@type='submit']").click()
        #Click on Users button from main navigation
        driver.find_element_by_xpath("//li[4]/a/span").click()
        print ('on users page')
        driver.find_element_by_xpath("//a[@ng-click='setCurrent(pagination.current + 1)']").click()
        # TakeScreeshot
        newtime = datetime.now().strftime("%Y%m%d%H%M%S")
        driver.save_screenshot(
            'C:\Users\UNI\PycharmProjects\Wave-Fits\TestSuite\Logs&Seccenshots\PaginationForUsersN\Pagination' + newtime + '.png')
        time.sleep(3)
        if driver.find_element_by_xpath("//a[contains(.,'2')]"):
            time.sleep(2)
            print("On 2nd page")

        else:
            print("Can't go to next page")

        driver.find_element_by_xpath("//a[@ng-click='setCurrent(pagination.current - 1)']").click()
        # TakeScreeshot
        newtime = datetime.now().strftime("%Y%m%d%H%M%S")
        driver.save_screenshot('C:\Users\UNI\PycharmProjects\Wave-Fits\TestSuite\Logs&Seccenshots\PaginationForUsersN\Pagination1' + newtime + '.png')
        time.sleep(3)
        if driver.find_element_by_xpath("//a[contains(.,'1')]"):
            time.sleep(2)
            print("On 1st page")
        else:
            print("Can't go to previous page")



def tearDown(self):
        self.driver.quit()