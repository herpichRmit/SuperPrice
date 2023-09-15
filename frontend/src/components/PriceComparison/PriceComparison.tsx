import React from 'react'
import './PriceComparison.css'

export default function PriceComparison({fullSize = true}) {
  return (
    <div className="price-comparison">

        <div className="pc_entry">
            <img src="" alt="" />
            <div className="pc_entry-priceandbutton">
              <p>Price 1</p>
              <button>Add to cart</button>
            </div>
        </div>

        <hr />
        
        <div className="pc_entry">
            <img src="" alt="" />
            <div className="pc_entry-priceandbutton">
              <p>Price 2</p>
              <button>Add to cart</button>
            </div>
        </div>

        <hr />

        <div className="pc_entry">
            <img src="" alt="" />
            <div className="pc_entry-priceandbutton">
              <p>Price 3</p>
              <button>Add to cart</button>
            </div>
        </div>

    </div>


      
  )
}
