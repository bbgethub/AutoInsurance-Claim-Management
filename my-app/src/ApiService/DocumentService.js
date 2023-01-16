export const uploadDocument = async (data) => {

   let response = await fetch('http://localhost:8080/api/document/upload', {
      method: 'POST',
      body: data,
    })
    return response.json();
   
    };


      export const getDocument = async (docId) => {
         var url = "http://localhost:8080/api/document/" + docId;  
         await fetch(url, {
         method: 'GET',
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

         export const deleteDocument = async (docId) => {
            var url = "http://localhost:8080/api/document/" + docId;  
            await fetch(url, {
            method: 'DELETE',
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

            export const updateClaim = async (docId,body) => {
               var url = "http://localhost:8080/api/document/" + docId;  
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