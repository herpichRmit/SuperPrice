import { switchPage } from '../../app/page'

import HomePage from '../../pages/HomePage/HomePage'

export default function BackButton () {
    let className = "back-button btn btn-light"
    let click = () => switchPage (<HomePage />)

    return <button className={className} onClick={click} > Back </button>
}
