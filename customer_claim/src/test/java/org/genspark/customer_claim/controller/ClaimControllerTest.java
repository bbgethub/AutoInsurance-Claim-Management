package org.genspark.customer_claim.controller;

import org.genspark.customer_claim.service.ClaimService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class ClaimControllerTest {


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Mock
    ClaimService claimService;
    @InjectMocks
    ClaimController claimController;
    void testCreateNewClaim() throws Exception
    {

    }
}