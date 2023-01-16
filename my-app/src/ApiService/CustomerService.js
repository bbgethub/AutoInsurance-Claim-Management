export const getCustomersByIds = async (data) => {
     
   let url= 'http://localhost:8080/api/customer/getFor/'+data;

   let response = await fetch(url, {
   method: 'GET',
   headers: {
      'Content-type': 'application/json; charset=UTF-8',
   },
   })

   return response.json();
   }; 

   export const createCustomer = async (body) => {
      debugger;
      let response = await fetch('http://localhost:8080/api/customer/create', {
      method: 'POST',
      body: JSON.stringify(body),
      headers: {
         'Content-type': 'application/json; charset=UTF-8',
      },
      });
      return response.json();
      };