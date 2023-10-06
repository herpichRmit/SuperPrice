/*
import './PriceCompare.css'

interface PriceProps {
    store : String
    priceCents : number
}

interface PricesProps {
    prices: PriceProps[]
}

export default function PriceCompare ({ prices } : PricesProps) {
    let priceComponents = pricesToComponents (prices);

    ["coles", "woolworths", "aldi"].forEach (store => {
        if (!priceComponents [store]) {
            priceComponents [store] = <div className="price"></div>
        }
    })

    return (
        <div className="price-compare">
            {priceComponents.coles}
            {priceComponents.woolworths}
            {priceComponents.aldi}
        </div>
    )
}

let storeIcons = {
    "COLES"      : "/resources/store-icons/coles.png",
    "WOOLWORTHS" : "/resources/store-icons/woolworths.png",
    "ALDI"       : "/resources/store-icons/aldi.png"
}

function Price ({ store, priceCents } : PriceProps) {
    return (
        <div className="price">
            <img className="store-icon" src={storeIcons [store]} />
            <div className="price-price">
                {formatPrice (priceCents)}
            </div>
        </div>
    )
}

function formatPrice (priceCents : number)  {
    let dollars = Math.floor (priceCents / 100)
    let cents = priceCents % 100;

    let result = "$" + dollars + "." + cents

    if (cents < 10) {
        result += "0"
    }

    return result
}

function pricesToComponents (prices) {
    let map = {}

    prices.forEach (price => {
        map [price.store.toLowerCase ()] = <Price price={price} />
    })

    return map
}

*/