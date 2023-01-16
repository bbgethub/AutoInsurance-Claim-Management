import {getClaims} from '../../ApiService/ClaimService'
import {getPoliciesByIds} from '../../ApiService/PolicyService'
import {getCustomersByIds} from '../../ApiService/CustomerService'
import MOCK_DATA from './MOCK_DATA.json'
import _ from 'lodash';

export const getClaimsdetails = async () => {
    console.log("123###")

    //return MOCK_DATA;
   // return MOCK_DATA;
    let claimData = await getClaims();
    claimData = _.map(claimData , function(claim) { 
        return _.assign({}, claim, {claimId: (claim.id)});
   });

    debugger;
    debugger;

  //  debugger;
    let claimPolicyIds = _.uniqBy(_.map(claimData, 'policyNumber'));
    let policyData = await getPoliciesByIds(claimPolicyIds);

    let customerIds = _.uniqBy(_.map(policyData, 'customerid'));
    let custData = await getCustomersByIds(customerIds);

    let claimPolicyData = _.map(claimData, function(p){
        return _.merge(
            p, 
            _.find(policyData, {number: p.policyNumber})
        )
    });
    debugger;
    let claimPolicyCustomerData = _.map(claimData, function(p){
        return _.merge(
            p, 
            _.find(claimPolicyData, {id: p.id})
        )
    });
    console.log("****### claimData = ",claimData);
    console.log("****### policyData =",policyData);
    console.log("****### custData =",custData);
    console.log("****### claimPolicyData =",claimPolicyData);
    console.log("****### claimPolicyCustomerData =",claimPolicyCustomerData);
    return claimPolicyCustomerData;
    
    };  