package com.shivam.recyclerviewhandf.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shivam.recyclerviewhandf.R;
import com.shivam.recyclerviewhandf.models.Item;
import com.shivam.recyclerviewhandf.models.Footer;
import com.shivam.recyclerviewhandf.models.Header;
import com.shivam.recyclerviewhandf.models.RecyclerViewItem;


import java.util.List;


public class Adapter extends RecyclerView.Adapter {
    //Declare List of Recyclerview Items
    List<RecyclerViewItem> recyclerViewItems;
    //Header Item Type
    private static final int HEADER_ITEM = 0;
    //Footer Item Type
    private static final int FOOTER_ITEM = 1;
    ////Food Item Type
    private static final int ITEM = 2;
    Context mContext;

    public Adapter(List<RecyclerViewItem> recyclerViewItems, Context mContext) {
        this.recyclerViewItems = recyclerViewItems;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row;
        //Check fot view Type inflate layout according to it
        if (viewType == HEADER_ITEM) {
            row = inflater.inflate(R.layout.custom_row_header, parent, false);
            return new HeaderHolder(row);
        } else if (viewType == FOOTER_ITEM) {
            row = inflater.inflate(R.layout.custom_row_footer, parent, false);
            return new FooterHolder(row);
        } else if (viewType == ITEM) {
            row = inflater.inflate(R.layout.custom_row, parent, false);
            return new ItemHolder(row);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecyclerViewItem recyclerViewItem = recyclerViewItems.get(position);
        //Check holder instance to populate data  according to it
        if (holder instanceof HeaderHolder) {
            HeaderHolder headerHolder = (HeaderHolder) holder;
            Header header = (Header) recyclerViewItem;
            //set data
            headerHolder.texViewHeaderText.setText(header.getHeaderText());
            headerHolder.textViewCategory.setText(header.getCategory());
            Glide.with(mContext).load(header.getImageUrl()).into(headerHolder.imageViewHeader);

        } else if (holder instanceof FooterHolder) {
            FooterHolder footerHolder = (FooterHolder) holder;
            Footer footer = (Footer) recyclerViewItem;
            //set data
            footerHolder.texViewQuote.setText(footer.getQuote());
            footerHolder.textViewAuthor.setText(footer.getAuthor());
            Glide.with(mContext).load(footer.getImageUrl()).into(footerHolder.imageViewFooter);

        } else if (holder instanceof ItemHolder) {
            ItemHolder itemHolder = (ItemHolder) holder;
            Item item = (Item) recyclerViewItem;
            //set data
            itemHolder.texViewTitle.setText(item.getTitle());
            itemHolder.texViewDescription.setText(item.getDescription());
            Glide.with(mContext).load(item.getImageUrl()).into(itemHolder.imageView);

        }

    }

    @Override
    public int getItemViewType(int position) {
        //here we can set view type
        RecyclerViewItem recyclerViewItem = recyclerViewItems.get(position);
        //if its header then return header item
        if (recyclerViewItem instanceof Header)
            return HEADER_ITEM;
            //if its Footer then return Footer item
        else if (recyclerViewItem instanceof Footer)
            return FOOTER_ITEM;
        //if its Item then return  item
        else if (recyclerViewItem instanceof Item)
            return ITEM;
        else
            return super.getItemViewType(position);

    }

    @Override
    public int getItemCount() {
        return recyclerViewItems.size();
    }
    //Food item holder
    private class ItemHolder extends RecyclerView.ViewHolder {
        TextView texViewTitle, texViewDescription;
        ImageView imageView;

        ItemHolder(View itemView) {
            super(itemView);
            texViewTitle = itemView.findViewById(R.id.texViewTitle);
            texViewDescription = itemView.findViewById(R.id.texViewDescription);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
    //header holder
    private class HeaderHolder extends RecyclerView.ViewHolder {
        TextView texViewHeaderText, textViewCategory;
        ImageView imageViewHeader;

        HeaderHolder(View itemView) {
            super(itemView);
            texViewHeaderText = itemView.findViewById(R.id.texViewHeaderText);
            textViewCategory = itemView.findViewById(R.id.textViewCategory);
            imageViewHeader = itemView.findViewById(R.id.imageViewHeader);
        }
    }
    //footer holder
    private class FooterHolder extends RecyclerView.ViewHolder {
        TextView texViewQuote, textViewAuthor;
        ImageView imageViewFooter;

        FooterHolder(View itemView) {
            super(itemView);
            texViewQuote = itemView.findViewById(R.id.texViewQuote);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
            imageViewFooter = itemView.findViewById(R.id.imageViewFooter);
        }
    }
}
