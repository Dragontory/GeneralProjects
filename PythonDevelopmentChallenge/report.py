
#Python Development Challenge
#Tory Yang
#4/25/2023

import sys
import argparse

running_script = sys.argv[0]

def main():
    parser = argparse.ArgumentParser()

    parser.add_argument("-t", help="Name of TeamMap CSV File")
    parser.add_argument("-p", help="Name of ProductMaster CSV File")
    parser.add_argument("-s", help="Name of Sales CSV File")
    parser.add_argument("--team-report", help="Name of TeamReport Output File", dest='TeamReportOutput')
    parser.add_argument("--product-report", help="Name of ProductsReport Output File", dest='ProductReportOutput')

    args = parser.parse_args()

    # Reads TeamMap Input File
    if args.t is not None:
        TeamMap = {}
        with open(args.t) as teamMapInputFile:
            #Skips the header
            next(teamMapInputFile)
            for line in teamMapInputFile:
                line = line.rstrip()
                #Stores TeamID and Name into a list
                (TeamID, Name) = line.split(',')
                TeamMap[int(TeamID)] = Name
    else:
        print('File did not open correctly :(')

    # Reads ProductMaster Input File
    if args.p is not None:
        ProductMaster = {}
        with open(args.p) as productMasterInputFile:
            for line in productMasterInputFile:
                line = line.rstrip()
                #Stores info in a list
                (ProductID, ProductName, Price, LotSize) = line.split(',')
                ProductMaster[int(ProductID)] = {'name' : ProductName, 'price' : Price, 'lotsize' : LotSize}
    else:
        print('File did not open correctly :(')

    # Read the Sales Input file
    if args.s is not None:
        Sales = {}
        TeamRevenue = {}
        ProductReport = {}

        with open(args.s) as salesInputFile:
            for line in salesInputFile:
                line = line.rstrip()
                (SalesID, ProductID, TeamID, Quantity, Discount) = line.split(',')

                #Calculates Product Revenue and Discount Cost
                productRevenue = float(ProductMaster[int(ProductID)]['price']) * int(ProductMaster[int(ProductID)]['lotsize'])*int(Quantity)
                discountCost = productRevenue * float(Discount)/100

                #Stores info into a list 
                Sales[int(SalesID)] = {'productid' : ProductID, 'teamid' : TeamID, 'quantity' : int(Quantity), 'total_sale' : productRevenue, 'discount' : Discount}
                TeamRevenue[int(TeamID)] = TeamRevenue.get(TeamMap[int(TeamID)],0) + Sales[int(SalesID)]['total_sale']
                ProductReport[int(ProductID)] = {'grossrevenue': productRevenue, 'totalunits': Quantity, 'discountcost': discountCost}

    else:
        print('File did not open correctly :(')
 

    #########################
    # Generate Reports
    ##########################

    #TeamReport Output File
    if args.TeamReportOutput is not None:
        #Opens output file
        Team_Report = open(args.TeamReportOutput, "w")
        Team_Report.write("Team, Gross Revenue")
        Team_Report.write('\n')

        #Sorts Team Report in descending order of Gross Revenue
        sortedTeamRevenue = sorted(TeamRevenue.items(), reverse=True)

        #Writes Team info to TeamReport Output File
        for key, value in sortedTeamRevenue:
            Team_Report.write("%s, %s" % (TeamMap[key], value))
            Team_Report.write('\n')

        Team_Report.close()

    #ProductReport Output File
    if args.ProductReportOutput is not None:
        #Opens output file
        Product_Report = open(args.ProductReportOutput, "w")
        Product_Report.write("Name, GrossRevenue, TotalUnits, DiscountCost")
        Product_Report.write('\n')

        #Sorts Product Report in descending order of Gross Revenue
        sortedProductReport = sorted(ProductReport.items(), reverse=True)

        #Writes info to Productreport Output File
        for key, value in sortedProductReport:

            Product_Report.write(str(ProductMaster[key]['name']))
            Product_Report.write(", ")
            Product_Report.write(str(ProductReport[key]['grossrevenue']))
            Product_Report.write(", ")
            Product_Report.write(str(ProductReport[key]['totalunits']))
            Product_Report.write(", ")
            Product_Report.write(str(ProductReport[key]['discountcost']))

            Product_Report.write('\n')

        Product_Report.close()

main()
