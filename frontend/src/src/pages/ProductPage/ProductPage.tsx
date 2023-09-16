import NavBar from '../../components/NavBar/NavBar';
import PriceComparison from '../../components/PriceComparison/PriceComparison';
import './ProductPage.css'

/*
<PriceComparison/>
<PriceComparison/>
<AlternateProductMenu/>
*/




export default function ProductPage() {
  return (
    <div className="product-page">
        <NavBar shouldShowSearchBar={false}/>
        <main>
            <div className="header_row">
              <button>Back</button>
              <h1>Product details</h1>
              <div></div>
            </div>
            <div className="pp_container">

              <div className="pp_container-product">

                <div className="pp_container-product_box">
                  <div className="pp_container-product_box-img"> <p>image</p> </div>
                  <div className="pp_container-product_box-comparison">
                    <h2>Product data</h2>
                    <PriceComparison />
                  </div>
                </div>

                <div className="pp_container-product_details">
                  <p>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Illo totam quia voluptas repellendus possimus et, 
                    voluptate libero at vel incidunt nemo illum delectus, aspernatur ea nesciunt tempore perferendis neque quis?
                  </p>
                </div>

              </div>
              <div className="alternativeProductMenu"><p>other</p></div>
            </div>



        </main>
    </div>
  )
}
