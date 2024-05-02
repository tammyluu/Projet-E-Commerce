import React from "react";
import Header from "./Header";
import { useParams } from "react-router-dom";
import { Link } from "react-router-dom";

const products = [
    {
        "id": 1,
        "name": "T-shirt",
        "price": 15.99,
        "category-id": 1
    },
    {
        "id": 2,
        "name": "Pants",
        "price": 29.99,
        "category-id": 1
    },
    {
        "id": 3,
        "name": "Shoes",
        "price": 49.99,
        "category-id": 1
    },
    {
        "id": 4,
        "name": "Watch",
        "price": 99.99,
        "category-id": 2
    }
    ,
    {
        "id": 32,
        "name": "Shoes",
        "price": 49.99,
        "category-id": 1
    },{
        "id": 35,
        "name": "Shoes",
        "price": 49.99,
        "category-id": 1
    },{
        "id": 36,
        "name": "Shoes",
        "price": 49.99,
        "category-id": 1
    },{
        "id": 38,
        "name": "Shoes",
        "price": 49.99,
        "category-id": 1
    }
    
];


function ProductView() {
    const { id } = useParams();
    // Filtrer les produits par catégorie
    const filteredProducts = id
        ? products.filter(product => product["id"] == id)
        : products;

        const product = filteredProducts.length > 0 ? filteredProducts[0] : null;

    // Vérifier si un produit a été trouvé

    return (
        <>
            <Header />
            <div className="container">
                <div className="row">
                    <div className="col-md-5">
                        {/* remplacer par l'image avec l'url dédié */}
                        <div className="photo"></div>
                    </div>
                    <div className="col-md-6 productDesciption">
                        <div className="productName">
                            <h2>{product.name } </h2>
                            <h3>{product.price} €</h3>
                            <div className="btn btn-success addCart">Ajouter au panier</div>
                            
                        </div>
                    </div>

                </div>
                <br />
                <Link to={"/products"}>

                <div className="btn btn-dark"> Retour</div>
                </Link>
            </div>
        </>
    );
}

export default ProductView
