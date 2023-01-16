export const getPolicies = async () => {
 
   let response = await fetch('http://localhost:8080/api/policy/getAll', {
   method: 'GET',
   headers: {
      'Content-type': 'application/json; charset=UTF-8',
   },
   })

   return response.json();
   }; 

   export const getPoliciesByIds = async (data) => {
     
      let url= 'http://localhost:8080/api/policy/getFor/'+data;
      
      let response = await fetch(url, {
      method: 'GET',
      headers: {
         'Content-type': 'application/json; charset=UTF-8',
      },
      })
    
      return response.json();
      };    

   export const createPolicy = async (body) => {
         debugger;
         let response = await fetch('http://localhost:8080/api/policy/create', {
         method: 'POST',
         body: JSON.stringify(body),
         headers: {
            'Content-type': 'application/json; charset=UTF-8',
         },
         });
         return response.json();
         };

      export const updatePolicy = async (body) => {
            debugger;
            let url= 'http://localhost:8080/api/policy/'+body.number;
            let response = await fetch(url, {
            method: 'PUT',
            body: JSON.stringify(body),
            headers: {
               'Content-type': 'application/json; charset=UTF-8',
            },
            });
            return response.json();
            };