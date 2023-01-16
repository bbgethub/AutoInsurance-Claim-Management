import React, { useState, useEffect,useMemo} from 'react'
import { useTable,useSortBy, usePagination } from 'react-table'
import { useNavigate } from "react-router-dom";
import MOCK_DATA from './MOCK_DATA.json'

import {getClaimsdetails} from './ClaimListService'
import {COLUMNS} from './Column'
import './ClaimList.css'
 
function ClaimList() {

    const columns = useMemo(() => COLUMNS, []);

    const navigate = useNavigate();
    
    const viewDetails = (rowName) => {
        console.log("This row was clicked:", rowName)
        debugger;
        console.log("Clicked, new value = " + rowName);
        navigate("/create/");


    }

     const [data, setData] = useState([]);
     const [loadingData, setLoadingData] = useState(true);
     const tableInstance = useTable({
        columns,
        data
    }, useSortBy,usePagination)
    
  useEffect(() => {
    async function getData() {
        setData(await getClaimsdetails());
        setLoadingData(false);
    }
    if (loadingData) {
      // if the result is not ready so you make the axios call
      getData();
    }
  }, []);
   
 
 
 
    const { getTableProps, getTableBodyProps, headerGroups, page, nextPage, previousPage, prepareRow,} = tableInstance
  return (
    <>
    <table {...getTableProps() } >
        <thead>
            {headerGroups.map((headerGroup) => (
                <tr {...headerGroup.getHeaderGroupProps()}>
                    {headerGroup.headers.map((column) => (
                        <th {...column.getHeaderProps(column.getSortByToggleProps())}>{column.render('Header')}
                           </th>
                    ))}
                </tr>
            ))}
        </thead>
        <tbody {...getTableBodyProps()} >
            {
                page.map(row => {
                    console.log("1 ",row);
                   // console.log("2 ",row.getRowProps());
                    console.log("3 ",row.value)
                    console.log("4 ", row.values.claimId)
                    console.log("5 ",row.claimId)
                    prepareRow(row)
                    return (
                        <tr {...row.getRowProps()} onRowClick={viewDetails}>
                                {row.cells.map((cell) => {
                                return <td {...cell.getCellProps()}>{cell.render('Cell')}</td>
                            })}
                        </tr>
                    )
                })
            }
        </tbody>
        <div>
            <button onClick={() => previousPage()}>Previous</button>
            <button onClick={() => nextPage()}>Next</button>
            <button onClick={(e) => viewDetails(e)}>Details</button>
        </div>
    </table>
    </>
  )
}
 
export default ClaimList