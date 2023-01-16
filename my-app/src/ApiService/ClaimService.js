export const createClaim = async (body) => {
    debugger;
    let response = await fetch('http://localhost:8080/api/claim/create', {
    method: 'POST',
    body: JSON.stringify(body),
    headers: {
       'Content-type': 'application/json; charset=UTF-8',
    },
    });
    debugger;
    return response.json();
    };

   export const getClaims = async () => {

      let response = await fetch('http://localhost:8080/api/claim/getAll', {
      method: 'GET',
      headers: {
         'Content-type': 'application/json; charset=UTF-8',
      },
      });
      return response.json();
      };  
     
      export const getClaim = async (claimId) => {
       
         var url = "http://localhost:8080/api/claim/" + claimId;  
         let response = await fetch(url, {
         method: 'GET',
         headers: {
            'Content-type': 'application/json; charset=UTF-8',
         },
         })
     
         return response.json();
         };   

         export const deleteClaim = async (claimId) => {
       
            var url = "http://localhost:8080/api/claim/" + claimId;  
            let response = await fetch(url, {
            method: 'DELETE',
            headers: {
               'Content-type': 'application/json; charset=UTF-8',
            },
            })
         
            return response.json();
           };   

            export const updateClaim = async (claimId,body) => {
            
               var url = "http://localhost:8080/api/claim/" + claimId;  
               await fetch(url, {
               method: 'PUT',
               body: JSON.stringify(body),
               headers: {
                  'Content-type': 'application/json; charset=UTF-8',
               },
               })
               .then((response) => response.json())
               .then((data) => {
           
               })
               .catch((err) => {
                  console.log(err.message);
               });
               };