package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    InvoiceGenerator cabInvoiceGenerator = new InvoiceGenerator();

    @Test
    public void givenDistanceAndTime_WhenCalculated_ReturnTotalFare()
    {
        double cabInvoiceGeneratorTotalFare = cabInvoiceGenerator.getTotalFare(5.0, 5);
        Assert.assertEquals(55.0, cabInvoiceGeneratorTotalFare, 0);
    }

    @Test
    public void givenDistanceAndTime_WhenLessThanMinimumFareGetCalculated_ThenReturnMinimumFare()
    {
        double cabInvoiceGeneratorTotalFare = cabInvoiceGenerator.getTotalFare(0.132, 1);
        Assert.assertEquals(5, cabInvoiceGeneratorTotalFare, 0);
    }

    @Test
    public void givenMultipleRides_WhenCalculated_ReturnTotalFare()
    {
        Ride[] rides = {new Ride(26.05, 29), new Ride(12.39, 25)};
        double cabInvoiceGeneratorTotalFare = cabInvoiceGenerator.getTotalFare(rides);
        Assert.assertEquals(438.4, cabInvoiceGeneratorTotalFare, 0);
    }

    @Test
    public void givenMultipleRides_WhenCalculated_ReturnInvoiceSummery()
    {
        Ride[] rides = {new Ride(25.12, 40), new Ride(12.39, 25)};
        InvoiceSummary invoiceSummary = cabInvoiceGenerator.getInvoiceSummary(rides);
        InvoiceSummary summary = new InvoiceSummary(2, 440.1);
        Assert.assertEquals(summary, invoiceSummary);
    }
}
